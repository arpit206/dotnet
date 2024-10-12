package com.jpa.test.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.test.model.Author;
import com.jpa.test.model.Tutorial;
import com.jpa.test.repository.AuthorRepository;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
  @Autowired
  private AuthorRepository authorRepository;

  public TutorialResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Tutorial tutorial) {
    return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
  }
}



