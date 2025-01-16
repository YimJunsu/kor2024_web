package day63task.service;

import day63task.model.dto.ListDto;
import day63task.model.entity.ListEntity;
import day63task.model.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {
    @Autowired private ListRepository listRepository;

    public boolean upload(ListDto listDto){
        ListEntity listEntity = listDto.toEntity();
        ListEntity saveEntity = listRepository.save(listEntity);
        if(saveEntity.getLno() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<ListDto> view(){
        List<ListEntity> entityList = listRepository.findAll();
        List<ListDto> list = new ArrayList<>();
        for (int index = 0; index <= entityList.size() -1; index++) {
            ListEntity entity = entityList.get(index);
            list.add(entity.toDto());
        }
        return list;
    }
    @Transactional
    public boolean change(ListDto listDto){
        ListEntity updateEntity = listRepository.findById(listDto.getLno()).get();
        updateEntity.setLstatus(listDto.isLstatus());
        return true;
    }

    public boolean remove(int lno){
        listRepository.deleteById(lno);
        return true;
    }
}
