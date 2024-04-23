package br.controller;

import br.domain.dto.FoodRequestDTO;
import br.domain.dto.FoodResponseDTO;
import br.domain.entities.Food;
import br.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    @PostMapping
    public void salveAll(@RequestBody FoodRequestDTO foodRequestDTO){
        Food foodDate = new Food(foodRequestDTO);
        foodRepository.save(foodDate);
    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }


}
