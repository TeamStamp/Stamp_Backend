package example.stamp.CrsLoadInteractors;
import com.example.stamp.CrsLoadInteractors.CrsLoadServiceImpl;
import com.example.stamp.CrsLoadInteractors.CrsRepository;
import com.example.stamp.CrsLoadInteractors.RequestCrsDto;
import com.example.stamp.CrsLoadInteractors.ResponseCrsDto;
import com.example.stamp.Entities.CrsEntity;
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

        CrsEntity crs1 = CrsEntity.builder().id(1L).CrsName("Crs1").CrsMakerToken("1").build();
        CrsEntity crs2 = CrsEntity.builder().id(2L).CrsName("Crs2").CrsMakerToken("1").build();

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

    @Test
    public void testGetCrs() {
        // 레포지토리 동작을 모킹합니다.
        CrsEntity crs = CrsEntity.builder().id(1L).CrsName("Crs1").CrsMakerToken("1").build();
        when(repository.findById(1L)).thenReturn(Optional.of(crs));
        // 서비스 메서드를 호출합니다.
        RequestCrsDto request = RequestCrsDto.builder().id(1L).build();
        ResponseCrsDto response = service.getCrs(request);
        // 결과를 검증합니다.
        assertEquals("Crs1", response.getCrsName());
        assertEquals("1", response.getCrsMakerToken());
        // 로그를 출력합니다.
        System.out.println("Expected: id=1, CrsName=Crs1, CrsMakerToken=1");
        System.out.println("Actual: " + response);

        // 초기 데이터 삭제
        repository.delete(crs);
    }

}
