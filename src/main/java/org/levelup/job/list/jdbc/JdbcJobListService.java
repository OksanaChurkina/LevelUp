package org.levelup.job.list.jdbc;

import org.levelup.job.list.domain.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("All")
public class JdbcJobListService {

    public Position createPosition(String name) throws SQLException
    {
        Connection connection = JdbcUtils.getConnection();
        //insert/ select/ update/ delete
        //statement
        //Preparestatement -   не допускает sql инъекции
        //Callablestatement - запускает function/ procedure(sql)

       PreparedStatement statement = connection.prepareStatement("insert into positions (name) values (?)");
        statement.setString(1, name);

      int rowChanged = statement.executeUpdate(); //insert//update//delete
        System.out.println("Количество измененных строк" + rowChanged);

        Statement selectStatement = connection.createStatement();
        ResultSet resultSet = selectStatement.executeQuery("select * from positions where name = '" + name + "'"); //select
        //iterator отсутствует метод hasnext()
//        while(resultSet.next())
//        {
//           int id = resultSet.getInt(1);
//            String positionName = resultSet.getString("name");
//            System.out.println("Должность: ID = " + id + ", name = " + positionName);
//        }
        resultSet.next();
        int id = resultSet.getInt(1);
        String positionName = resultSet.getString("name");
        System.out.println("Должность: ID = " + id + ", name = " + positionName);

        //ORM - object relation mapping
        return new Position(id, positionName);

    }

    public Collection<Position> findAll() throws SQLException{
        try(Connection connection = JdbcUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from positions");

            return extractPositions(resultSet);
        }
    }

    private Collection<Position> extractPositions(ResultSet resultSet) throws SQLException{
        Collection<Position> positions = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            positions.add(new Position(id, name));
        }

        return positions;
    }

    public Collection<Position> findPositionWithNameLike(String name) throws SQLException{

        try(Connection connection = JdbcUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from positions where name like ?");
            //like
            //"%Developer ->
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return extractPositions(resultSet);
        }
    }
    public void deletePosition(String name)throws SQLException{
        //try-with-resource
        try(Connection connection = JdbcUtils.getConnection()){
        PreparedStatement statement = connection.prepareStatement("delete from positions where name = ?");
        statement.setString(1, name);

        int rowDeleted = statement.executeUpdate();
            System.out.println("Удалено позиций: " + rowDeleted);
        }
        //connection.close()
    }
}
