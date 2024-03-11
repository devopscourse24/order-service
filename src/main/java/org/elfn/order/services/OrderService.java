package org.elfn.order.services;

import org.elfn.order.dtos.OrderDTO;
import org.elfn.order.dtos.OrderDTOFromFront;
import org.elfn.order.dtos.User;
import org.elfn.order.entities.Order;
import org.elfn.order.mappers.OrderMapper;
import org.elfn.order.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);


    final OrderRepository orderRepository;
    final SequenceGenerator sequenceGenerator;

    final RestService restService;

    public OrderService(OrderRepository orderRepository, SequenceGenerator sequenceGenerator, RestService restService) {
        this.orderRepository = orderRepository;
        this.sequenceGenerator = sequenceGenerator;
        this.restService = restService;
    }

    public OrderDTO saveOrderInDb(OrderDTOFromFront orderDetails) throws Exception {
        try {
            int newOrderID = sequenceGenerator.generateNextOrderId();

            // Récupère les détails de l'utilisateur à partir de l'ID utilisateur fourni dans les détails de la commande.
            User userDTO = restService.fetchUserDetailsFromUserId(orderDetails.getUserId());

            // Crée une nouvelle commande avec l'ID de la nouvelle commande, la liste des articles alimentaires, le restaurant, et les détails de l'utilisateur.
            Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemList(), orderDetails.getRestaurant(), userDTO);

            orderRepository.save(orderToBeSaved);
//            System.out.println( OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved).getFoodItemList());
//            System.out.println( orderToBeSaved.getFoodItemList());

            return  OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);

        } catch (Exception e) {
            // Enregistrez l'exception avec un système de logging. Par exemple, en utilisant SLF4J :
            logger.error("Erreur lors de la sauvegarde de la commande", e);
            // Vous pouvez aussi renvoyer une réponse personnalisée ou lancer une nouvelle exception qui sera gérée plus haut dans le contrôleur.
            throw new Exception("Impossible de sauvegarder la commande", e);
        }


    }



}
