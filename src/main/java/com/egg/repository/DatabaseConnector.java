package com.egg.repository;

/** Creates a connection for the application's configured database. */
public abstract class DatabaseConnector<ConnectionType> {

    public abstract ConnectionType createConnection();
}
