package example.stamp.test;

import com.example.stamp.CrsLoadInteractors.ResponseCrsDto;
import com.example.stamp.Entities.PlcEntity;
import com.example.stamp.Entities.UserEntity;
import com.example.stamp.PlaceLoadInteractors.PlcLoadServiceImpl;
import com.example.stamp.PlaceLoadInteractors.PlcRepository;
import com.example.stamp.PlaceLoadInteractors.RequestPlcDto;
import com.example.stamp.PlaceLoadInteractors.ResponsePlcDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PlcLoadServiceImplTest {

    @Mock
    private PlcRepository repository;

    @InjectMocks
    private PlcLoadServiceImpl service;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPlc() {
        // 초기 데이터 설정
        List<PlcEntity> plcList = new ArrayList<>();
        UserEntity user1 = new UserEntity(1L,null,null,null,null,null,null);
        UserEntity user2= new UserEntity(2L,null,null,null,null,null,null);
        PlcEntity plc1 = PlcEntity.builder().id(1L).PlcName("Plc1").Lat("123").Lng("321").Category("음식점").ImgUrl("AAA").UserId(user1).build();
        PlcEntity plc2 = PlcEntity.builder().id(2L).PlcName("Plc2").Lat("111").Lng("222").Category("숙소").ImgUrl("BBB").UserId(user2).build();

        plcList.add(plc1);
        plcList.add(plc2);
// 실제 DB에서 데이터를 가져오는 것 대신 초기 데이터를 이용하여 검증합니다.
        Mockito.when(repository.findAll(Sort.by(Sort.Direction.DESC, "id"))).thenReturn(plcList);
// 서비스 메서드를 호출합니다.
        List<ResponsePlcDto> response = service.getAllPlc();
// 결과를 검증합니다.
        ResponsePlcDto[] expected = {ResponsePlcDto.of(plc1), ResponsePlcDto.of(plc2)};
        ResponsePlcDto[] actual = response.toArray(new ResponsePlcDto[0]);
        assertArrayEquals(expected, actual);

// 로그를 출력합니다.
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));

    }

    @Test
    public void testGetPlc() {
        // 레포지토리 동작을 모킹합니다.
        UserEntity user1 = new UserEntity(1L,null,null,null,null,null,null);
        PlcEntity plc = PlcEntity.builder().id(1L).PlcName("Plc1").Lat("123").Lng("321").Category("음식점").ImgUrl("AAA").UserId(user1).build();
        when(repository.findById(1L)).thenReturn(Optional.of(plc));
        // 서비스 메서드를 호출합니다.
        RequestPlcDto request = RequestPlcDto.builder().id(1L).build();
        ResponsePlcDto response = service.getPlc(request);
        // 결과를 검증합니다.
        assertEquals("Plc1", response.getPlcName());
        assertEquals("123", response.getLat());
        assertEquals("321", response.getLng());
        assertEquals("음식점", response.getCategory());
        assertEquals("AAA", response.getImgUrl());
        assertEquals(1, response.getUserId());

        // 로그를 출력합니다.
        System.out.println("Expected: " + ResponsePlcDto.of(plc) );
        System.out.println("Actual: " + response);

        // 초기 데이터 삭제
        repository.delete(plc);
    }

}
