package ir.maktabsharif.repository.bank;

import ir.maktabsharif.entity.Bank;
import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRepositoryImpl extends BaseEntityRepositoryImpl implements BankRepository {
    @Override
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    protected String getTableName() {
        return Bank.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return new Bank(resultSet.getLong("id"),resultSet.getString("name"));
    }
}
