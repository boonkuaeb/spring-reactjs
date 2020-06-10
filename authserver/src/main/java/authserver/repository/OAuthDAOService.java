package authserver.repository;

import authserver.model.UserEntity;

public interface OAuthDAOService {

    public UserEntity getUserDetails(String emailId);
}