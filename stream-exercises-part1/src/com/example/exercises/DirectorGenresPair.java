package com.example.exercises;

import java.util.List;

import com.example.domain.Director;
import com.example.domain.Genre;

record DirectorGenresPair(Director director,List<Genre> genres) { }