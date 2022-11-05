package com.example.demobullsht.demobullsht.controller;

import com.example.demobullsht.demobullsht.entity.WorkPlaceEntity;
import com.example.demobullsht.demobullsht.service.WorkPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class WorkPlaceController {
    private final WorkPlaceService workPlaceService;

    /*@Autowired
    public WorkPlaceController(WorkPlaceService workPlaceService) {
        this.workPlaceService = workPlaceService;
    }*/

    @GetMapping("/")
    public List<WorkPlaceEntity> getWorkPlace() {
        return workPlaceService.getWorkPlace();
    }
    //убрать опшнл
    @GetMapping("/{id}")
    public Optional<WorkPlaceEntity> getFindById(@PathVariable Long id){
        return workPlaceService.getWorkPlaceById(id);
    }
    @GetMapping("/{seatId}")
    public Optional<WorkPlaceEntity> getFindByNumberSeat(@PathVariable String seatId){
        return workPlaceService.getWorkPlaceByNumberSeat(seatId);
    }

    @PostMapping
    public void registerNewWorkPlace(@RequestBody WorkPlaceEntity workPlaceEntity) {
        workPlaceService.addNewWorkPlaceEntity(workPlaceEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkPlaceEntity(@PathVariable Long id){
        workPlaceService.deleteWorkPlaceEntity(id);;
    }

    @PutMapping("/{id}")
    public void updateEmployeeEntity(
            @PathVariable Long id,
            @RequestParam(required = false) String numberSeat){
        workPlaceService.updateWorkPlaceEntity(id, numberSeat);
    }
}