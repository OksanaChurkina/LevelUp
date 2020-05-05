package org.levelup.job.list;

import org.levelup.job.list.domain.Position;
import org.levelup.job.list.jdbc.JdbcJobListService;

import java.sql.SQLException;
import java.util.Collection;

public class JobListApplication {

    public static void main(String[] args) throws SQLException {
        JdbcJobListService service = new JdbcJobListService();
        //service.createPosition("DevOps2");
        service.deletePosition("DevOps2");
        for(int i =0; i<10; i++)
        {
            service.createPosition("Dev" + i);
        }

        System.out.println();
        Collection<Position> allPositions = service.findAll();
        for(Position position : allPositions){
            System.out.println(position.getId() + " " + position.getName());
        }

        System.out.println();
        Collection<Position> likePositions = service.findPositionWithNameLike("Dev%");
        for(Position position : likePositions){
            System.out.println(position.getId() + " " + position.getName());
        }

    }
}
