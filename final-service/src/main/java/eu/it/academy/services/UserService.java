package eu.it.academy.services;

import eu.it.academy.api.dao.IPetJPADao;
import eu.it.academy.api.dao.IUserJPADao;
import eu.it.academy.api.dto.UserDto;
import eu.it.academy.api.dto.UserPetIdsDto;
import eu.it.academy.api.mappers.UserMapper;
import eu.it.academy.api.services.IUserService;
import eu.it.academy.entities.Pet;
import eu.it.academy.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserJPADao userJPADao;

    @Autowired
    private IPetJPADao petJPADao;

    @Override
    public UserDto findUser(int id) {
        User user = this.userJPADao.findById(id).orElse(null);
        return (user != null) ? UserMapper.mapUserDto(user) : null;
    }

    @Override
    public UserDto findUserByFirstName(String firstName) {
        return UserMapper.mapUserDto(this.userJPADao.findByFirstName(firstName));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return UserMapper.mapUserDto(this.userJPADao.save(UserMapper.mapUser(userDto)));
    }

    @Override
    @Transactional
    public void updateUser(int id, UserDto userDto) {
        User user = this.userJPADao.findById(id).orElse(null);
        if (user != null && userDto != null) {
            User userUpdate = UserMapper.mapUser(userDto);
            if (userUpdate.getFirstName() != null) user.setFirstName(userUpdate.getFirstName());
            if (userUpdate.getSalary() >= 0) user.setSalary(userUpdate.getSalary());
            this.userJPADao.save(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userJPADao.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        return UserMapper.mapUserDtos(userJPADao.findAll());
    }

    @Override
    @Transactional
    public void assignPetToUser(UserPetIdsDto ids) {
        User user = this.userJPADao.findById(ids.getUserId()).orElse(null);
        Pet pet = this.petJPADao.findById(ids.getPetId()).orElse(null);
        if (pet != null) {
            pet.setUser(user);
            this.petJPADao.save(pet);
        }
    }

//    @Procedure("random")
//    Integer randomStoreProcedure();
//    @Autowired
//    private IUserDao userDao;
//
//    @Override
//    public UserDto findUser(int id) {
//        User user = this.userDao.get(id);
//        return UserMapper.mapUserDto(user);
//    }
//
//    @Override
//    @Transactional
//    public UserDto createUser(UserDto user) {
//        User entity = UserMapper.mapUser(user);
//        entity.setPets(new ArrayList<>());
//        User savedUser = this.userDao.create(entity);
//        return UserMapper.mapUserDto(savedUser);
//    }
//
//    @Override
//    @Transactional
//    public void updateUser(int id, UserDto user) {
//        User entity = this.userDao.get(id);
//        entity.setFirstName(Optional.ofNullable(user.getFirstName()).orElse("DefaultName"));
//        entity.setSalary(user.getSalary());
//        this.userDao.update(entity);
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(int id) {
//        User entity = this.userDao.get(id);
//        this.userDao.delete(entity);
//    }
//
//    @Override
//    public List<UserDto> getUsers() {
//        return UserMapper.mapUserDtos(this.userDao.getAll());
//    }
}