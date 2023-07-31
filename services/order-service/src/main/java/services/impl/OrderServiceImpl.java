package services.impl;

import lombok.extern.slf4j.Slf4j;
import model.Order;
import model.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repostitory.OrderRepository;
import services.AbstractService;
import services.JwtService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements AbstractService<Order> {
    OrderRepository repository;
    JwtService jwtService;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, JwtService jwtService) {
        this.repository = repository;
        this.jwtService = jwtService;
    }

    @Override
    public List<Order> getAll(String token) {
        if (jwtService.validate(token)) {
            return repository.findAll();
        }
        return null;
    }

    @Override
    public boolean insert(String token, Order body) {
        try {
            String username = jwtService.getUsername(token);
            Date date = new Date();
            body.setCreated(date);
            body.setUpdated(date);
            body.setStatus(Status.CREATED);
            body.setCreatedBy(username);
            body.setUpdatedBy(username);
            repository.save(body);
            return true;
        } catch (Exception ex) {
            log.error("Ошибка при создании заявки", ex);
            return false;
        }

    }

    @Override
    public boolean updateById(String token, Long id, Order body) {
        try {
            String username = jwtService.getUsername(token);
            Date date = new Date();
            Optional<Order> optOrder = repository.findById(id);
            if (optOrder.isEmpty()) {
                log.info("Нет данных для обновления");
                return false;
            }
            Order order = optOrder.get();
            order.setUpdatedBy(username);
            order.setName(body.getName());
            order.setUpdated(date);
            order.setStatus(body.getStatus());
            repository.save(order);
            return true;
        } catch (Exception ex) {
            log.error("Ошибка при обновлении данных", ex);
            return false;
        }
    }

    @Override
    public boolean delete(String token, Long id) {
        try {
            String username = jwtService.getUsername(token);
            Date date = new Date();
            Optional<Order> optOrder = repository.findById(id);
            if (optOrder.isEmpty()) {
                log.info("Нет данных для обновления");
                return false;
            }
            Order order = optOrder.get();
            order.setUpdatedBy(username);
            order.setUpdated(date);
            order.setStatus(Status.DELETED);
            repository.save(order);
            return true;
        } catch (Exception ex) {
            log.error("Ошибка при обновлении данных", ex);
            return false;
        }
    }
}
