//package com.example.data
//
//import javax.inject.Inject
//
//class UserRepositoryImpl @Inject constructor(
//    private val localDataSource: UserLocalDataSource
//) : UserRepository {
//    override suspend fun getUser(): User {
//        return localDataSource.getUser()
//    }
//
//    override suspend fun updateUser(user: User) {
//        localDataSource.updateUser(user)
//    }
//}
