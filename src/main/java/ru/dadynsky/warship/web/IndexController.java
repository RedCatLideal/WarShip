package ru.dadynsky.warship.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.dadynsky.warship.model.Ship;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping(value = {"/","/index.html"})
    public String index(Model model, HttpSession session){
        int[][] pole = new int[10][10];
        if (session.getAttribute("pole") == null){
            placeShip(pole);
            session.setAttribute("pole", pole);
        }
        else{
            pole = (int[][]) session.getAttribute("pole");
        }

        model.addAttribute("pole", pole);
        return "index";
    }
    @RequestMapping(value = {"/fire",})
    @ResponseBody
    public String fire(Integer x, Integer y,HttpSession session){
        int[][] pole = (int[][])session.getAttribute("pole");
        if(pole[y][x] != 0){
            pole[y][x] = -1;
            return "Ok";
        }
        else{
            return "no Ok";
        }
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
    public void placeShip(int[][] pole){
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
    }




}
