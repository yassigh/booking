package com.example.myhotel;

public class Amenity {

        private String name;
        private int icon;

        public Amenity(String name, int icon) {
            this.name = name;
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public int getIcon() {
            return icon;
        }


}
