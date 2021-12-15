package Sample.hello.Repository;

import Sample.hello.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    private static long sequence=0L;
    Map<Long , Member> store=new HashMap<>();

    public Member save(Member member){
        member.setId(sequence++);
        store.put(member.getId(),member);
        return member;
    }
    public void clear(){
        store.clear();
    }
    public Optional<Member> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    public Optional<Member> findName(String name){
        return findAll().stream().filter(m->m.getName().equals(name)).findFirst();
    }

}
