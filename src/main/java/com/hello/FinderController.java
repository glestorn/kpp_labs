package com.hello;

import com.hello.Finder;
import com.services.finder_service.FinderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FinderController {

    private FinderService finderService;
    private static final Logger logger = Logger.getLogger(FinderController.class);

    @Autowired
    public FinderController(FinderService finderService) {
        this.finderService = finderService;
    }

    @RequestMapping("/finder")
    public ResponseEntity finder(@RequestParam String row,
                                 @RequestParam char symbol) {

        if (finderService.validate(symbol, row)) {

            if ((int)symbol == 32) {
                logger.info("There is an user error");
                return ResponseEntity.status(400).body("Invalid parametres");
            }

            logger.info("HTTP status 200");
            return ResponseEntity.ok(finderService.process(symbol, row).getContent());
        }

        else {

            logger.info("There is an server error");
            return ResponseEntity.status(500).body("Server error");
        }
    }
}
