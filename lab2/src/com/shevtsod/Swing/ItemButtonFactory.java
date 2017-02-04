package com.shevtsod.Swing;

/**
 * FILENAME: ItemButtonFactory.java
 *
 * PURPOSE:
 *  Factory for quickly creating pre-made ItemButtons
 *
 * CLASS: ENSE471
 * ASSIGNMENT: lab2
 * DATE: Feb. 02, 2017
 *
 * NAME: Daniel Shevtsov
 * SID: 200351253
 */
public class ItemButtonFactory {
    /**
     * Returns a populated ItemButton object based on the category and number of item
     * @param category
     *      Menu category to which the item belongs
     *      pre: category > 0
     * @param itemNumber
     *      The number of the menu item within the category
     *      pre: itemNumber > 0
     * @return
     *      Populated ItemButton object
     */
    public ItemButton getMenuItemButton(int category, int itemNumber) {
        /*
        MENU CATEGORY CODES:
        0 - Appetizers
        1 - Vegetarian Flavours
        2 - Non-Vegetarian Flavours
        3 - Beverages
         */
        switch(category) {
            case 0: return getAppetizerItemButton(itemNumber);
            case 1: return getVegetarianItemButton(itemNumber);
            case 2: return getNonVegetarianItemButton(itemNumber);
            case 3: return getBeverageItemButton(itemNumber);
            default: return null;
        }
    }

    /**
     * Returns a populated ItemButton object for an Appetizer menu item, depending on the item number
     * @param itemNumber
     *      The number of the menu item within the category
     *      pre: itemNumber > 0
     * @return
     *      Populated ItemButton object
     */
    private ItemButton getAppetizerItemButton(int itemNumber) {
        String title, description;
        double price;

        /*
        ITEM NUMBER CODES:
        0 - Veggie Samosa (2 pcs)
        1 - Veggie Pakora
        2 - Aaloo Tikki (2 pcs)
        3 - Paneer Pakora
         */
        switch(itemNumber) {
            case 0:
                title = "Veggie Samosa (2 pcs)";
                description = "Crisp patties stuffed with potatoes, served with tamarind sauce.";
                price = 3.00;
                break;
            case 1:
                title = "Veggie Pakora";
                description = "Fresh vegetables, potato, cauliflower, onions & spinach, mixed with " +
                        "spices and graham flour, deep fried.";
                price = 5.99;
                break;
            case 2:
                title = "Aaloo Tikki (2 pcs)";
                description = "Mashed potato patties deep fried served with chutney.";
                price = 3.50;
                break;
            case 3:
                title = "Paneer Pakora";
                description = "Home made cheese battered with graham flour, deep fried, served with " +
                        "traditional Indian chutney.";
                price = 7.99;
                break;
            default:
                return null;
        }

        return new ItemButton(title, description, price);
    }

    /**
     * Returns a populated ItemButton object for a Vegetarian Flavour menu item, depending on the item number
     * @param itemNumber
     *      The number of the menu item within the category
     *      pre: itemNumber > 0
     * @return
     *      Populated ItemButton object
     */
    private ItemButton getVegetarianItemButton(int itemNumber) {
        String title, description;
        double price;

        /*
        ITEM NUMBER CODES:
        0 - Daal Makhni
        1 - Palak Paneer
        2 - Chana Masala
        3 - Malai Kofta
         */
        switch(itemNumber) {
            case 0:
                title = "Daal Makhni";
                description = "Creamed Lentils with aromatic spices.";
                price = 9.99;
                break;
            case 1:
                title = "Palak Paneer";
                description = "Home made cheese cooked with curried spinach.";
                price = 11.99;
                break;
            case 2:
                title = "Chana Masala";
                description = "Chick Peas cooked with authentic spices in curry sauce.";
                price = 9.99;
                break;
            case 3:
                title = "Malai Kofta";
                description = "Grated cottage cheese scoops filled with potatoes & nuts " +
                        "simmered in exotic gravy.";
                price = 12.99;
                break;
            default:
                return null;
        }

        return new ItemButton(title, description, price);
    }

    /**
     * Returns a populated ItemButton object for a Non-Vegetarian Flavour menu item, depending on the item number
     * @param itemNumber
     *      The number of the menu item within the category
     *      pre: itemNumber > 0
     * @return
     *      Populated ItemButton object
     */
    private ItemButton getNonVegetarianItemButton(int itemNumber) {
        String title, description;
        double price;

        /*
        ITEM NUMBER CODES:
        0 - Butter Chicken
        1 - Palak Chicken
        2 - Curry Chicken
        3 - Lamb Curry
         */
        switch(itemNumber) {
            case 0:
                title = "Butter Chicken";
                description = "Boneless chicken cooked in our special creamy butter sauce.";
                price = 14.99;
                break;
            case 1:
                title = "Palak Chicken";
                description = "Boneless pieces of chicken cooked in freshly chopped spinach in Punjabi style.";
                price = 14.99;
                break;
            case 2:
                title = "Curry Chicken";
                description = "Boneless chicken pieces cooked in curry sauce, garlic, ginger & Indian spices.";
                price = 13.99;
                break;
            case 3:
                title = "Lamb Curry";
                description = "Boneless lamb pieces cooked in onions, garlic & fresh tomatoes.";
                price = 14.99;
                break;
            default:
                return null;
        }

        return new ItemButton(title, description, price);
    }

    /**
     * Returns a populated ItemButton object for a Beverage menu item, depending on the item number
     * @param itemNumber
     *      The number of the menu item within the category
     *      pre: itemNumber > 0
     * @return
     *      Populated ItemButton object
     */
    private ItemButton getBeverageItemButton(int itemNumber) {
        String title, description;
        double price;

        /*
        ITEM NUMBER CODES:
        0 - Pop Cans
        1 - Mangoo Lassi
        2 - Juices
        3 - Masala Tea
         */
        switch(itemNumber) {
            case 0:
                title = "Pop Cans";
                description = "Coke, Diet Coke, Sprite, Soda etc.";
                price = 1.50;
                break;
            case 1:
                title = "Mangoo Lassi";
                description = "Lassi made from fresh Yogurt milk, Mango Pich of salt or sugar and milk cream.";
                price = 2.99;
                break;
            case 2:
                title = "Juices";
                description = "Orange, Apple, Pineapple, Cranberry.";
                price = 1.99;
                break;
            case 3:
                title = "Masala Tea";
                description = "Indian tea prepared in East indian style with traditional spices.";
                price = 1.99;
                break;
            default:
                return null;
        }

        return new ItemButton(title, description, price);
    }
}
