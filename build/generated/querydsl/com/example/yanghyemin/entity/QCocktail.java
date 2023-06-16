package com.example.yanghyemin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCocktail is a Querydsl query type for Cocktail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCocktail extends EntityPathBase<Cocktail> {

    private static final long serialVersionUID = 1562879729L;

    public static final QCocktail cocktail = new QCocktail("cocktail");

    public final NumberPath<Float> alcohol = createNumber("alcohol", Float.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath ingredients = createString("ingredients");

    public final StringPath instruction = createString("instruction");

    public final StringPath name = createString("name");

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final NumberPath<Float> sweet = createNumber("sweet", Float.class);

    public final StringPath Url = createString("Url");

    public QCocktail(String variable) {
        super(Cocktail.class, forVariable(variable));
    }

    public QCocktail(Path<? extends Cocktail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCocktail(PathMetadata metadata) {
        super(Cocktail.class, metadata);
    }

}

