package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 컴포넌트 스캔의 대상이 됨
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); // 실제는 hashmap 사용하면 안됨 동시에 접근하면 값이 꼬일 수 있기 때문에. static
    private static long sequence = 0L; //static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values()); // 감싸서 반환하게 되면 store 에는 영향이 가지 않음. 객체 복사 개념.
    }

    public void update(Long itemId, Item updateParam){ // 원래는 updateItem 용 dto를 만드는게 맞음. 개발자는 중복보다는 명확성이 더 중요함...
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear(); // hashMap data clear
    }
}
