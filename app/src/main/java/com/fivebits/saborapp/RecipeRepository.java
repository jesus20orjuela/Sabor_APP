package com.fivebits.saborapp;
import java.util.*;

public final class RecipeRepository {
    private RecipeRepository(){}

    public static List<Recipe> all(){
        List<Recipe> data = new ArrayList<>();
        data.add(new Recipe(1, "Ajiaco santafereño", "60 min · 4 porciones",
                "• 500 g de pechuga de pollo\n• 3 tipos de papa\n• 2 mazorcas\n• Guascas\n• Alcaparras y crema al gusto",
                "1. Cocina el pollo y la mazorca.\n2. Agrega las papas y cocina hasta espesar.\n3. Incorpora las guascas.\n4. Sirve con crema y alcaparras."));
        data.add(new Recipe(2, "Arroz de la casa", "40 min · 4 porciones",
                "• 2 tazas de arroz\n• 1 pechuga de pollo\n• Pimentón\n• Zanahoria\n• Arvejas",
                "1. Cocina el arroz.\n2. Sofríe los vegetales y el pollo.\n3. Mezcla todo y rectifica la sazón."));
        data.add(new Recipe(3, "Sancocho de gallina", "90 min · 6 porciones",
                "• Gallina\n• Yuca\n• Plátano verde\n• Mazorca\n• Papa\n• Cilantro",
                "1. Cocina la gallina.\n2. Agrega plátano y mazorca.\n3. Incorpora yuca y papa.\n4. Cocina hasta que todo esté tierno y finaliza con cilantro."));
        data.add(new Recipe(4, "Postre de nata", "35 min · 6 porciones",
                "• 1 litro de leche\n• Azúcar\n• Canela\n• Uvas pasas",
                "1. Calienta la leche y recoge la nata.\n2. Prepara un almíbar suave.\n3. Integra las natas y cocina a fuego bajo.\n4. Sirve frío."));
        return data;
    }

    public static Recipe byId(int id){
        for(Recipe r : all()) if(r.getId()==id) return r;
        return all().get(0);
    }
}
