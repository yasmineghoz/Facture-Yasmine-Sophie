package facture;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    
    private Map<String,Article> Articles ;
    
    public Catalogue (){
        this.Articles = new HashMap<>();
    }
    
    public void addArticle(Article article) {
        Articles.put(article.getCode(), article);
    }
    
    public Article findByCode(String code) {
        return Articles.get(code);
    }
    
}
