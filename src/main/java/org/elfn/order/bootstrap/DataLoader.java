package org.elfn.order.bootstrap;

import org.elfn.order.dtos.FoodItem;
import org.elfn.order.dtos.Restaurant;
import org.elfn.order.dtos.User;
import org.elfn.order.entities.Order;
import org.elfn.order.repositories.OrderRepository;
import org.elfn.order.services.OrderService;
import org.elfn.order.services.RestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    final RestService restService;
    final OrderRepository orderRepository;

    public DataLoader(RestService restService, OrderRepository orderRepository) {
        this.restService = restService;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
         loadData();
    }

    private void loadData() {

        Restaurant antoinette = new Restaurant(1152, "Chez Antoinette", "Rue des Jardins, Cocody", "Abidjan", "Une expérience authentique de la cuisine ivoirienne avec une touche moderne");
        Restaurant bistroLePatriote = new Restaurant(1153, "Le Patriote", "Avenue Franchet d'Esperey, Treichville", "Abidjan", "Dégustez les saveurs locales dans une ambiance conviviale et chaleureuse.");
        Restaurant cafeDeLaPaix = new Restaurant(1154, "Café de la Paix", "Boulevard de la République, Plateau", "Abidjan", "Un café historique offrant des pâtisseries fines et un café d'exception.");
        Restaurant laPerleNoire = new Restaurant(1155, "La Perle Noire", "Rue Louis Lumière, Marcory", "Abidjan", "Un voyage culinaire qui met en avant la richesse des produits de la mer.");
        Restaurant leJardinGourmand = new Restaurant(1156, "Le Jardin Gourmand", "Rue des Flamboyants, Deux Plateaux", "Abidjan", "Un cadre idyllique pour une cuisine innovante et raffinée.");
        Restaurant lEpicurien = new Restaurant(1157, "L'Épicurien", "Avenue Noguès, Le Plateau", "Abidjan", "L'excellence de la gastronomie française au cœur d'Abidjan.");

        // Articles pour le restaurant Chez Antoinette
        FoodItem kedjenou = new FoodItem(1, "Poulet Kedjenou", "Poulet mijoté avec des épices et des légumes dans un pot en terre", false, 5000L, 1, 0);
        FoodItem aloco = new FoodItem(2, "Aloco", "Bananes plantains frites servies avec une sauce tomate épicée", false, 2500L, 1152, 0);
        FoodItem attiekePoisson = new FoodItem(3, "Attieke au Poisson", "Semoule de manioc avec poisson grillé et sauce oignons", false, 4500L, 1152, 0);
        FoodItem garba = new FoodItem(4, "Garba", "Thon émincé sur de l'attiéké avec des oignons et du piment", false, 2000L, 1152, 0);
        FoodItem pouletBraise = new FoodItem(5, "Poulet Braisé", "Poulet entier mariné et grillé au charbon", false, 5500L, 1152, 0);

// Articles pour le restaurant Le Patriote
        FoodItem foutouBanane = new FoodItem(6, "Foutou Banane", "Pâte de banane plantain accompagnée de sauce graine", false, 3500L, 1153, 0);
        FoodItem soupeKandji = new FoodItem(7, "Soupe Kandji", "Soupe de poisson fumé avec légumes locaux", false, 4000L, 1153, 0);
        FoodItem attiekePoulet = new FoodItem(8, "Attieke au Poulet", "Semoule de manioc avec poulet frit et sauce oignons", false, 4500L, 1153, 0);
        FoodItem braisedFish = new FoodItem(9, "Poisson Braisé", "Poisson frais grillé avec marinade épicée", false, 5000L, 1153, 0);

// Articles pour le café De La Paix
        FoodItem croissant = new FoodItem(10, "Croissant", "Viennoiserie au beurre frais", true, 1000L, 1154, 0);
        FoodItem eclairChocolat = new FoodItem(11, "Éclair au Chocolat", "Pâtisserie au chocolat et crème pâtissière", true, 1500L, 1154, 0);
        FoodItem milleFeuille = new FoodItem(12, "Mille-Feuille", "Gâteau superposé de pâte feuilletée et de crème", true, 2000L, 1154, 0);
        FoodItem tarteTatin = new FoodItem(13, "Tarte Tatin", "Tarte aux pommes caramélisées, servie tiède", true, 2500L, 1154, 0);

// Articles pour le restaurant La Perle Noire
        FoodItem fruitsDeMer = new FoodItem(14, "Assiette de Fruits de Mer", "Sélection de fruits de mer frais du jour", false, 7500L, 1155, 0);
        FoodItem poissonYassa = new FoodItem(15, "Poisson Yassa", "Poisson mariné dans une sauce aux oignons et citron", false, 6000L, 1155, 0);
        FoodItem crevettesSauce = new FoodItem(16, "Crevettes en Sauce", "Crevettes sautées dans une sauce tomate piquante", false, 6500L, 1155, 0);
        FoodItem calamarsFrits = new FoodItem(17, "Calamars Frits", "Calamars panés et frits, servis avec une mayonnaise épicée", false, 5000L, 1155, 0);

// Articles pour le restaurant L'Épicurien
        FoodItem souffleFromage = new FoodItem(22, "Soufflé au Fromage", "Un classique de la cuisine française, ce soufflé léger est fait avec du fromage comté et emmental.", true, 6000L, 1156, 0); // Un soufflé au fromage aéré et gourmand.
        FoodItem boeufBourguignon = new FoodItem(23, "Bœuf Bourguignon", "Ragoût de bœuf mijoté pendant des heures dans une sauce au vin rouge riche en saveurs, accompagné de petits légumes.", false, 8500L, 1156, 0); // Un plat réconfortant et riche en goût.
        FoodItem coqAuVin = new FoodItem(24, "Coq au Vin", "Poulet cuit lentement dans une sauce au vin avec des lardons et champignons, un plat riche en histoire et en goût.", false, 8000L, 1156, 0); // Une recette traditionnelle française.
        FoodItem ratatouille = new FoodItem(25, "Ratatouille", "Mélange harmonieux de légumes provençaux cuits à l'étouffée, une explosion de saveurs méditerranéennes.", true, 5000L, 1156, 0); // Un accompagnement sain et savoureux.

        // Articles pour le restaurant Le Jardin Gourmand
        FoodItem saladeGourmande = new FoodItem(18, "Salade Gourmande", "Salade composée de produits du marché", true, 3000L, 1157, 0);
        FoodItem filetMignon = new FoodItem(19, "Filet Mignon", "Filet mignon de porc, sauce aux champignons", false, 8000L, 1157, 0);
        FoodItem risottoAuxChampignons = new FoodItem(20, "Risotto aux Champignons", "Risotto crémeux aux champignons sauvages", true, 7000L, 1157, 0);
        FoodItem tournedosRossini = new FoodItem(21, "Tournedos Rossini", "Médaillon de filet de bœuf poêlé, surmonté de foie gras et nappé d'une sauce au truffe", false, 9500L, 1157, 0); // Un plat de haute gastronomie, hommage au célèbre compositeur Rossini.


        // Création d'un objet de type User nommé userDTO
        User userDTO = new User(202, "nomutilisateur", "motdepasse123", "22 rue des Jardins, Cocody", "Abidjan"); // Crée un nouvel utilisateur avec des informations spécifiques.


// Initialisation des listes de FoodItem pour chaque restaurant
        List<FoodItem> foodItemsChezAntoinette = new ArrayList<>();
        List<FoodItem> foodItemsLePatriote = new ArrayList<>();
        List<FoodItem> foodItemsCafeDeLaPaix = new ArrayList<>();
        List<FoodItem> foodItemsLaPerleNoire = new ArrayList<>();
        List<FoodItem> foodItemsLeJardinGourmand = new ArrayList<>();
        List<FoodItem> foodItemsLEpicurien = new ArrayList<>();

// Ajout des FoodItem dans la liste de Chez Antoinette
        foodItemsChezAntoinette.add(kedjenou);
        foodItemsChezAntoinette.add(aloco);
        foodItemsChezAntoinette.add(attiekePoisson);
        foodItemsChezAntoinette.add(garba);
        foodItemsChezAntoinette.add(pouletBraise);

// Ajout des FoodItem dans la liste du Le Patriote
        foodItemsLePatriote.add(foutouBanane);
        foodItemsLePatriote.add(soupeKandji);
        foodItemsLePatriote.add(attiekePoulet);
        foodItemsLePatriote.add(braisedFish);

// Ajout des FoodItem dans la liste du Café De La Paix
        foodItemsCafeDeLaPaix.add(croissant);
        foodItemsCafeDeLaPaix.add(eclairChocolat);
        foodItemsCafeDeLaPaix.add(milleFeuille);
        foodItemsCafeDeLaPaix.add(tarteTatin);

// Ajout des FoodItem dans la liste de La Perle Noire
        foodItemsLaPerleNoire.add(fruitsDeMer);
        foodItemsLaPerleNoire.add(poissonYassa);
        foodItemsLaPerleNoire.add(crevettesSauce);
        foodItemsLaPerleNoire.add(calamarsFrits);

// Ajout des FoodItem dans la liste du Le Jardin Gourmand
        foodItemsLeJardinGourmand.add(saladeGourmande);
        foodItemsLeJardinGourmand.add(filetMignon);
        foodItemsLeJardinGourmand.add(risottoAuxChampignons);
        foodItemsLeJardinGourmand.add(tournedosRossini);

// Ajout des FoodItem dans la liste de L'Épicurien
        foodItemsLEpicurien.add(souffleFromage);
        foodItemsLEpicurien.add(boeufBourguignon);
        foodItemsLEpicurien.add(coqAuVin);
        foodItemsLEpicurien.add(ratatouille);

        // Création des commandes pour chaque restaurant
        Order orderChezAntoinette = new Order(1, foodItemsChezAntoinette, antoinette, userDTO);
        Order orderLePatriote = new Order(2, foodItemsLePatriote, bistroLePatriote, userDTO);
        Order orderCafeDeLaPaix = new Order(3, foodItemsCafeDeLaPaix, cafeDeLaPaix, userDTO);
        Order orderLaPerleNoire = new Order(4, foodItemsLaPerleNoire, laPerleNoire, userDTO);
        Order orderLeJardinGourmand = new Order(5, foodItemsLeJardinGourmand, leJardinGourmand, userDTO);
        Order orderLEpicurien = new Order(6, foodItemsLEpicurien, lEpicurien, userDTO);


        // Sauvegarde de la commande pour le restaurant Chez Antoinette
        orderRepository.save(orderChezAntoinette);

// Sauvegarde de la commande pour le restaurant Le Patriote
        orderRepository.save(orderLePatriote);

// Sauvegarde de la commande pour le café De La Paix
        orderRepository.save(orderCafeDeLaPaix);

// Sauvegarde de la commande pour le restaurant La Perle Noire
        orderRepository.save(orderLaPerleNoire);

// Sauvegarde de la commande pour le restaurant Le Jardin Gourmand
        orderRepository.save(orderLeJardinGourmand);

// Sauvegarde de la commande pour le restaurant L'Épicurien
        orderRepository.save(orderLEpicurien);


    }
}
