package com.example.easynotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * class description goes here.
 */
@Repository
public interface NoteRepository extends JpaRepository <Note, Long> {
}
