package com.leetcode._2025_2;

import org.junit.Test;

import java.util.*;


/**
 * 2353. 设计食物评分系统
 *
 * @author DHW
 * @date 2025/2/28 9: 25
 * @Version 1.0
 */
public class ProblemsNo2353 {

    @Test
    public void solution() {
        String[] foods = new String[]{"czopaaeyl","lxoozsbh","kbaxapl"};
        String[] cuisines = new String[]{"dmnuqeatj","dmnuqeatj","dmnuqeatj"};
        int[] ratings = new int[]{11,2,15};
        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
        obj.changeRating("czopaaeyl",12);
        obj.changeRating("kbaxapl",8);
        obj.changeRating("lxoozsbh",5);
        obj.highestRated("dmnuqeatj");
    }

    class FoodRatings {

        Map<String, FoodRadio> foodMap;
        Map<String, TreeSet<FoodRadio>> cuisineMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodMap = new HashMap();
            cuisineMap = new HashMap();
            for (int i = 0; i < foods.length; i++) {
                FoodRadio foodRadio = new FoodRadio(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], foodRadio);
                TreeSet<FoodRadio> set = cuisineMap.getOrDefault(cuisines[i], new TreeSet<>());
                set.add(foodRadio);
                cuisineMap.put(cuisines[i], set);
            }
        }

        public void changeRating(String food, int newRating) {
            FoodRadio foodRadio = foodMap.get(food);
            TreeSet<FoodRadio> foodRadios = cuisineMap.get(foodRadio.getCuisine());
            foodRadios.remove(foodRadio);
            foodRadio.rating = newRating;
            foodRadios.add(foodRadio);
        }

        public String highestRated(String cuisine) {
            TreeSet<FoodRadio> foodRadios = cuisineMap.get(cuisine);
            return foodRadios.first().food;
        }

        class FoodRadio implements Comparable<FoodRadio>{
            String food;
            String cuisine;
            int rating;

            public FoodRadio() {
            }

            public FoodRadio(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            public String getFood() {
                return food;
            }

            public void setFood(String food) {
                this.food = food;
            }

            public String getCuisine() {
                return cuisine;
            }

            public void setCuisine(String cuisine) {
                this.cuisine = cuisine;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            @Override
            public int compareTo(FoodRadio o) {
                int i = o.rating - this.rating;
                if (i == 0) {
                    return this.food.compareTo(o.food);
                }
                return i;
            }
        }
    }


}

