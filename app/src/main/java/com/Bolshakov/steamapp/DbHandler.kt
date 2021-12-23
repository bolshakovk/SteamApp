package com.Bolshakov.steamapp

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class DbHandler {
    var connection: Connection? = null
    private fun getDbConnection(): Connection? {
        var connectionString = "jdbc://localhost:5432/steam-db"
        Class.forName("org.postgresql.Driver")
        connection = DriverManager.getConnection(connectionString, "postgres", "1488")
        return connection
    }
    fun signUpUser(user: User){
        var request = "INSERT INTO user(name, password) VALUES(?,?)"
        var prepareStatement = getDbConnection()?.prepareStatement(request)
        prepareStatement?.setString(1, user.name)
        prepareStatement?.setString(2, user.password)
    }
    fun getUser(user: User): ResultSet? {
        var resultSet: ResultSet? = null
        var request = "SELECT * FROM user WHERE name =? AND password =?"
        var prepareStatement = getDbConnection()?.prepareStatement(request)
        prepareStatement?.setString(1, user.name)
        prepareStatement?.setString(2, user.password)
        resultSet = prepareStatement?.executeQuery()
        return resultSet
    }
}