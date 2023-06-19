package com.example.yanghyemin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyFridge is a Querydsl query type for MyFridge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyFridge extends EntityPathBase<MyFridge> {

    private static final long serialVersionUID = 1272110494L;

    public static final QMyFridge myFridge = new QMyFridge("myFridge");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> ingredientsId = createNumber("ingredientsId", Long.class);

    public final StringPath ingredientsName = createString("ingredientsName");

    public final StringPath ingredientsUrl = createString("ingredientsUrl");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public QMyFridge(String variable) {
        super(MyFridge.class, forVariable(variable));
    }

    public QMyFridge(Path<? extends MyFridge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyFridge(PathMetadata metadata) {
        super(MyFridge.class, metadata);
    }

}

