package models;

public interface Model {
    public String toInsertSQL();
    public String toUpdateSQL();
    public String toDeletoSQL();
    
}
