package example.stamp.test;
import com.example.stamp.CrsLoadInteractors.*;
import com.example.stamp.Entities.CrsEntity;
import com.example.stamp.Entities.DayEntity;
import com.example.stamp.Entities.UserEntity;
import com.example.stamp.UnknownPersonInteractors.dto.UserRequestDto;
import com.example.stamp.UnknownPersonInteractors.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrsLoadServiceImplTest {

    @Mock
    private CrsRepository repository;

    @InjectMocks
    private CrsLoadServiceImpl service;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCrs() {
        // 초기 데이터 설정
        List<CrsEntity> crsList = new ArrayList<>();
        UserEntity user1 = new UserEntity(1L, null, null, null, null, null, null);
        UserEntity user2 = new UserEntity(2L, null, null, null, null, null, null);
        CrsEntity crs1 = CrsEntity.builder().id(1L).CrsName("Crs1").ImgUrl("AAA").UserId(user1).build();
        CrsEntity crs2 = CrsEntity.builder().id(2L).CrsName("Crs2").ImgUrl("BBB").UserId(user2).build();

        crsList.add(crs1);
        crsList.add(crs2);
// 실제 DB에서 데이터를 가져오는 것 대신 초기 데이터를 이용하여 검증합니다.
        Mockito.when(repository.findAll(Sort.by(Sort.Direction.DESC, "id"))).thenReturn(crsList);
// 서비스 메서드를 호출합니다.
        List<ResponseCrsDto> response = service.getAllCrs();
// 결과를 검증합니다.
        ResponseCrsDto[] expected = {ResponseCrsDto.of(crs1), ResponseCrsDto.of(crs2)};
        ResponseCrsDto[] actual = response.toArray(new ResponseCrsDto[0]);
        assertArrayEquals(expected, actual);

// 로그를 출력합니다.
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(actual));

    }

}