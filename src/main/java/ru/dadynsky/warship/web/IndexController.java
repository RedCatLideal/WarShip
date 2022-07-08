package ru.dadynsky.warship.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dadynsky.warship.model.Ship;

@Controller
public class IndexController {
    @RequestMapping(value = {"/","/index.html"})
    public String index(Model model){
        int[][] pole = new int[10][10];

        for(int i = 4; i > 0;i--){
            for(int j = i; j <= 4;j++){
                Ship ship = new Ship(i,pole);
                ship.putter();
            }
        }
        clearWater(pole);
        for(int y=0;y<10;y++){
            System.out.println();
            for(int x=0;x<10;x++){
                System.out.print(pole[x][y] + " ");
            }
        }
        model.addAttribute("pole",pole);
        return "index";
    }
    public void clearWater(int[][]pole){
        for(int y=0;y<10;y++){
            for(int x=0;x<10;x++){
                if (pole[x][y] == 5){
                    pole[x][y] = 0;
                }
            }
        }
    }
}
