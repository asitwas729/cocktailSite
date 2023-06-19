package com.example.yanghyemin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QIngredients is a Querydsl query type for Ingredients
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIngredients extends EntityPathBase<Ingredients> {

    private static final long serialVersionUID = 642280149L;

    public static final QIngredients ingredients = new QIngredients("ingredients");

    public final StringPath name = createString("name");

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath url = createString("url");

    public QIngredients(String variable) {
        super(Ingredients.class, forVariable(variable));
    }

    public QIngredients(Path<? extends Ingredients> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIngredients(PathMetadata metadata) {
        super(Ingredients.class, metadata);
    }

}

