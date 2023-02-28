/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.joui0005.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Purpose : Contains the setters , getters and necessary methods (implemented methods used by the restAPI) required to perform CRUD operations on sprites 
 * 
 * @author Mohamed Jouini
 * 
 * Student Id : 040994664
 * 
 * 
 * 
 */  
@Entity
public class Sprite implements Serializable {

    private static final long serialVersionUID = 1L;

    public final static Random random = new Random();

    final static int SIZE = 10;
    final static int MAX_SPEED = 5;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    private int panelWidth;
    @Column
    private int panelHeight;
    @Column
    private int x;
    @Column
    private int y;
    @Column
    private int dx;
    @Column
    private int dy;
    @Column
    private Color color = Color.BLUE;

    public Sprite() {
    }

    public Sprite(int height, int width) {
        this.panelWidth = width;
        this.panelHeight = height;
        x = random.nextInt(width);
        y = random.nextInt(height);
        dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
        dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
    }

    public Sprite(int height, int width, Color color) {
        this(height, width);
        this.color = color;
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public void move() {

        // check for bounce and make the ball bounce if necessary
        //
        if (x < 0 && dx < 0) {
            //bounce off the left wall 
            x = 0;
            dx = -dx;
        }
        if (y < 0 && dy < 0) {
            //bounce off the top wall
            y = 0;
            dy = -dy;
        }
        if (x > panelWidth - SIZE && dx > 0) {
            //bounce off the right wall
            x = panelWidth - SIZE;
            dx = -dx;
        }
        if (y > panelHeight - SIZE && dy > 0) {
            //bounce off the bottom wall
            y = panelHeight - SIZE;
            dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprite)) {
            return false;
        }
        Sprite other = (Sprite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    //updates sprites coordinations

    public void updateSprite(Sprite newSprite, Sprite oldSprite){  
            
         if (newSprite.getX() >=0 ){
            oldSprite.setX(newSprite.getX());}
          if (newSprite.getY() >=0 ){
            oldSprite.setY(newSprite.getY());}
           if (newSprite.getDx() >=0 ){
            oldSprite.setDx(newSprite.getDx());}
            if (newSprite.getDy() >=0 ){
            oldSprite.setDy(newSprite.getDy());}
       
        
    }
    
    
    /**
     * This method is implemented in RESTful API's. replaces the existing sprite with the one in the body of the request
     * @param newSprite -- the entity in the body of the request
     * @param oldSprite  -- the database entity that is replaced with newSprite values
     */
    public void replaceSprite(Sprite newSprite, Sprite oldSprite){
      
        if (newSprite.getX() >=0 ){
            oldSprite.setX(newSprite.getX());}
               if (newSprite.getY() >=0 ){
            oldSprite.setY(newSprite.getY());}
            
           if (newSprite.getDx() >=0 ){
            oldSprite.setDx(newSprite.getDx());}
        
         if (newSprite.getDy() >=0 ){
            oldSprite.setDy(newSprite.getDy());}
        
      
            oldSprite.setX(-1);
  
            oldSprite.setY(-1);
  
            oldSprite.setDx(-1);
     
            oldSprite.setDy(-1);
       
    }
    @Override
    public String toString() {
        return "entities.Sprite[ id=" + id + " ]";
    }

}
