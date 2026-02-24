package com.Swiggy.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// @RequestMapping("/food")
public class SwiggyController {
	
    @Autowired
    SwiggyService service;

    @PostMapping
    public ResponseEntity<Object> savefood(@RequestBody Food food){
        return service.savefood(food);
    }
	@

	@GetMapping("/")
	public String sujanGit(){
		return "SUJAN";
	}
	
	
    // @GetMapping
    // public ResponseEntity<Object> getAllFoods() {
    //     return service.getAllFoods();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFoodById(@PathVariable int id) {
        return service.getFoodById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFood(@PathVariable int id, @RequestBody Food food) {
        return service.updateFood(id, food);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFood(@PathVariable int id) {
        return service.deleteFood(id);
    }
}
