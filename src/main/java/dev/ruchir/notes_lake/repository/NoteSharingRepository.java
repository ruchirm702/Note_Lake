package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.NoteSharing;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import dev.ruchir.notes_lake.model.Core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteSharingRepository extends JpaRepository<NoteSharing, Long> {

    @Query("SELECT ns FROM NoteSharing ns WHERE ns.user = :user")
    List<NoteSharing> findByUser(@Param("user") User user);

    @Query("SELECT ns FROM NoteSharing ns WHERE ns.user.id = :userId")
    List<NoteSharing> findByUserId(@Param("userId") Long userId);

    @Query("SELECT ns FROM NoteSharing ns WHERE ns.handwrittenNote = :handwrittenNote")
    List<NoteSharing> findByHandwrittenNote(@Param("handwrittenNote") HandwrittenNote handwrittenNote);

    @Query("SELECT ns FROM NoteSharing ns WHERE ns.typedNote = :typedNote")
    List<NoteSharing> findByTypedNote(@Param("typedNote") TypedNote typedNote);

    @Query("SELECT ns FROM NoteSharing ns WHERE ns.user = :user AND ns.handwrittenNote = :handwrittenNote")
    List<NoteSharing> findByUserAndHandwrittenNote(@Param("user") User user, @Param("handwrittenNote") HandwrittenNote handwrittenNote);

    @Query("SELECT ns FROM NoteSharing ns WHERE ns.user = :user AND ns.typedNote = :typedNote")
    List<NoteSharing> findByUserAndTypedNote(@Param("user") User user, @Param("typedNote") TypedNote typedNote);
}
