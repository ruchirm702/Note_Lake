package dev.ruchir.notes_lake.repository;

import dev.ruchir.notes_lake.model.Core.UserGroup;
import dev.ruchir.notes_lake.model.Core.User;
import dev.ruchir.notes_lake.model.Core.HandwrittenNote;
import dev.ruchir.notes_lake.model.Core.TypedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    @Query("SELECT ug FROM UserGroup ug WHERE ug.groupName = :groupName")
    UserGroup findByGroupName(@Param("groupName") String groupName);

    @Query("SELECT ug FROM UserGroup ug JOIN ug.members m WHERE m = :user")
    List<UserGroup> findByUser(@Param("user") User user);

    @Query("SELECT ug FROM UserGroup ug JOIN ug.sharedHandwrittenNotes hnn WHERE hnn = :handwrittenNote")
    List<UserGroup> findBySharedHandwrittenNote(@Param("handwrittenNote") HandwrittenNote handwrittenNote);

    @Query("SELECT ug FROM UserGroup ug JOIN ug.sharedTypedNotes tnn WHERE tnn = :typedNote")
    List<UserGroup> findBySharedTypedNote(@Param("typedNote") TypedNote typedNote);
}
