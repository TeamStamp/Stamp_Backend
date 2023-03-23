package com.example.stamp.CrsLoadInteractors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class CrsLoadServiceImpl implements CrsLoadService{

    private final CrsRepository repository;

    @Transactional(readOnly = true)
    public List<ResponseCrsDto> getAllCrs() {
        List<ResponseCrsDto> list = new ArrayList<>();
        repository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().forEach(crs -> list.add(ResponseCrsDto.of(crs)));
        return list;
    }

    @Transactional(readOnly = true)
    public ResponseCrsDto getCrs(RequestCrsDto dto){
        ResponseCrsDto Dto = ResponseCrsDto.of(repository.findById(dto.getId()).get());
        return Dto;}

}
