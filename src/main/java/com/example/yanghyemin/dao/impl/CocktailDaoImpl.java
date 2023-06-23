package com.example.yanghyemin.dao.impl;

import com.example.yanghyemin.dao.CocktailDao;
import com.example.yanghyemin.entity.Cocktail;
import com.example.yanghyemin.repository.CocktailRepository;
import com.example.yanghyemin.repository.QCocktailRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.example.yanghyemin.entity.QCocktail.cocktail;

@Component
public class CocktailDaoImpl implements CocktailDao {
  private final CocktailRepository cocktailRepository;
  private final QCocktailRepository qCocktailRepository;
  private final JdbcTemplate jdbcTemplate;

  public CocktailDaoImpl(CocktailRepository cocktailRepository, QCocktailRepository qCocktailRepository, JdbcTemplate jdbcTemplate) {
    this.cocktailRepository = cocktailRepository;
    this.qCocktailRepository = qCocktailRepository;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Cocktail insertCocktail(Cocktail cocktail) {
    Cocktail saveCocktail = cocktailRepository.save(cocktail);
    return saveCocktail;
  }

  @Override
  public Cocktail updateCocktail(Long number, String name, String ingredients, String instruction,  String Url, Float alcohol, Float sweet) throws Exception {
    Optional<Cocktail> selectedCocktail = cocktailRepository.findById(number);
    Cocktail updateCocktail;

    if(selectedCocktail.isPresent()) {
      Cocktail cocktail = selectedCocktail.get();
      cocktail.setName(name);
      cocktail.setIngredients(ingredients);
      cocktail.setInstruction(instruction);
      cocktail.setUrl(Url);
      cocktail.setAlcohol(alcohol);
      cocktail.setSweet(sweet);


      updateCocktail = cocktailRepository.save(cocktail);
    } else throw new Exception();

    return updateCocktail;
  }

  @Override
  public void deleteCocktail(Long number) throws Exception {
    Optional<Cocktail> selectedCocktail = cocktailRepository.findById(number);

    if(selectedCocktail.isPresent()) {
      Cocktail cocktail = selectedCocktail.get();
      cocktailRepository.delete(cocktail);
    } else throw new Exception();
  }

  @Override
  public List<Cocktail> listAllCocktail() {
    List<Cocktail> cocktailList = cocktailRepository.findAll();
    return cocktailList;
  }

  @Override
  public List<Cocktail> listCocktailByCreatedAt() {
    List<Cocktail> cocktailList = cocktailRepository.findAllByOrderByCreatedAtDesc();
    return cocktailList;
  }

  @Override
  public List<Cocktail> listCocktailByName(String name) {
    List<Cocktail> cocktailList = cocktailRepository.findByNameContaining(name);
    return cocktailList;
  }

  @Override
  public List<Cocktail> listCocktailByIngredients(String ingredients) {
    List<Cocktail> cocktailList = cocktailRepository.findByIngredientsContaining(ingredients);
    return cocktailList;
  }

  @Override
  public List<Cocktail> listCocktailByNameContainingAndIngredientsContaining(String search) {
    List<Cocktail> cocktailList = cocktailRepository.findByNameContainingOrIngredientsContaining(search, search);
    return cocktailList;
  }

  @Override
  public List<Cocktail> listCocktailByIngredientsContainingOr(String s1, String s2, String s3) {
    String s11 = "%"+s1+"%";
    String s12 = "%"+s2+"%";
    String s13 = "%"+s3+"%";
    return jdbcTemplate.query("SELECT * FROM hackathon.cocktail WHERE cvs_ingredients LIKE ? or ? or ?", cocktailRowMapper(), s11, s12, s13);
  }

  private RowMapper<Cocktail> cocktailRowMapper(){  //객체 생성은 여기서 됨
    return (rs, rowNum) -> {  //람다로 바꿈
      Cocktail cocktail = new Cocktail();
      cocktail.setNumber(rs.getLong("cvs_id"));
      cocktail.setName(rs.getString("cvs_name"));
      cocktail.setIngredients(rs.getString("cvs_ingredients"));
      cocktail.setInstruction(rs.getString("cvs_instruction"));
      cocktail.setAlcohol(rs.getFloat("cvs_alcohol"));
      cocktail.setSweet(rs.getFloat("cvs_sweet"));
      cocktail.setUrl(rs.getString("cvs_url"));
      return cocktail;
    };
  }

  @Override
  public List<Cocktail> listCocktailByAlcohol(Float alcohol) {
    List<Cocktail> cocktailList = cocktailRepository.findByAlcohol(alcohol);
    return cocktailList;
  }


  @Override
  public Cocktail selectCocktail(Long number) {
    Predicate predicate = cocktail.number.eq(number);
    Optional<Cocktail> selectCocktail = qCocktailRepository.findOne(predicate);
    return selectCocktail.isPresent() ? selectCocktail.get() : null;
  }

}
