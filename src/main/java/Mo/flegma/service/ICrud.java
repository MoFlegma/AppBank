package Mo.flegma.service;

import java.util.List;

public interface ICrud <Entities, PrimaryKey>{
    public Entities create(Entities e);

    public List<Entities> listing();

    public Entities read(PrimaryKey pk);

    public Entities update(PrimaryKey pk, Entities e);

    public void delete(PrimaryKey pk);
}
