package com.example.yanghyemin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMBTI is a Querydsl query type for MBTI
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMBTI extends EntityPathBase<MBTI> {

    private static final long serialVersionUID = 974244855L;

    public static final QMBTI mBTI = new QMBTI("mBTI");

    public final StringPath best = createString("best");

    public final StringPath ex = createString("ex");

    public final StringPath keyword = createString("keyword");

    public final StringPath mbti = createString("mbti");

    public final StringPath name = createString("name");

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final StringPath url = createString("url");

    public final StringPath worst = createString("worst");

    public QMBTI(String variable) {
        super(MBTI.class, forVariable(variable));
    }

    public QMBTI(Path<? extends MBTI> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMBTI(PathMetadata metadata) {
        super(MBTI.class, metadata);
    }

}

