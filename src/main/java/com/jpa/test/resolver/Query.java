package com.jpa.test.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.test.model.Author;
import com.jpa.test.model.Tutorial;
import com.jpa.test.repository.AuthorRepository;
import com.jpa.test.repository.TutorialRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Component
public class Query implements GraphQLQueryResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;

  GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
          .aliasedScalar(ExtendedScalars.GraphQLLong)
          .build();

  @Autowired
  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
  }

  public Iterable<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public Iterable<Tutorial> findAllTutorials() {
    return tutorialRepository.findAll();
  }

  public long countAuthors() {
    return authorRepository.count();
  }

  public long countTutorials() {
    return tutorialRepository.count();
  }

}



