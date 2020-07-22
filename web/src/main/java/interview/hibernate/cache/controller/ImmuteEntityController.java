package interview.hibernate.cache.controller;

import interview.hibernate.cache.dao.ImmuteEntityRepo;
import interview.hibernate.cache.model.ImmuteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/immute")
public class ImmuteEntityController {
    @Autowired
    ImmuteEntityRepo immuteEntityRepo;
    @PutMapping("/immuteentity/{id}")
    public String updateImmuteEntity(@PathVariable("id") Long id){
        ImmuteEntity immuteEntity = immuteEntityRepo.findImmuteEntityById(id);
        immuteEntity.setName("immuteEntity3");//change name from immuteEntity1 to immuteEntity3
        /**
         * Since ImmuteEntity is labed by @Immutable,
         * so save/update will not be applied to db, and no exception thrown
         */
        immuteEntityRepo.save(immuteEntity);
        return "Update Ok!";
    }
}
