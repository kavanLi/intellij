/******************************************************************************
 *                         Libra FRAMEWORK
 *            Libra framework, (2018). All rights reserved.
 *
 *  All rights are reserved. Reproduction in whole or in part is prohibited
 *  without the written consent of the copyright owner.
 *****************************************************************************/
package com.example.easynotes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class description goes here.
 */
@RestController
@RequestMapping("/api")
public class NoteController {

    /* fields -------------------------------------------------------------- */

    @Autowired
    NoteRepository noteRepository;

    /* constructors -------------------------------------------------------- */

    /* public methods ------------------------------------------------------ */

    // Get All Notes
    @ApiOperation(value = "获取用户列表", notes = "可以获取所有列表")
    @GetMapping("/notes")
    public List <Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Create a new Note
     * The @Valid annotation makes sure that the request body is valid.
     * Remember, we had marked Note’s title and content with @NotBlank annotation in the Note model?
     * If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client.
     *
     * @param note
     * @return
     */
    @ApiOperation(value = "创建笔记", notes = "根据note对象创建笔记")
    @ApiImplicitParam(name = "note", value = "用户详细实体note", required = true, dataType = "Note")
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    /**
     * Get a Single Note
     * The @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter.
     * In the above method, we are returning a ResponseEntity<Note> instead of Note.
     * The ResponseEntity class gives us more flexibility while returning a response from the api.
     * For example, in the above api, If a note doesn’t exist with the given id,
     * then we’re returning a 404 Not Found error with the help of ResponseEntity.
     *
     * @param noteId
     * @return
     */
    @ApiOperation(value = "获取指定笔记信息", notes = "根据url的id来获取笔记详细信息")
    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @GetMapping("/notes/{id}")
    public ResponseEntity <Note> getNoteById(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }

    /**
     * Update a Note
     *
     * @param noteId
     * @param noteDetails
     * @return
     */
    @ApiOperation(value = "更新指定笔记详细信息", notes = "根据url的id来指定更新对象，并根据传过来的note信息来更新笔记详细信息")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id", value = "笔记ID", required = true, dataType = "Long"),
    //        @ApiImplicitParam(name = "note", value = "笔记详细实体note", required = true, dataType = "Note")
    //})
    @PutMapping("/notes/{id}")
    public ResponseEntity <Note> updateNote(@PathVariable(value = "id") Long noteId,
                                            @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findOne(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return ResponseEntity.ok(updatedNote);
    }

    // Delete a Note
    @ApiOperation(value = "删除指定笔记", notes = "根据url的id来指定删除对象")
    //@ApiImplicitParam(name = "id", value = "笔记ID", required = true, dataType = "Long")
    @DeleteMapping("/notes/{id}")
    public ResponseEntity <Note> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }

    // Now,It’s time to test our apis using postman
    @ApiOperation(value = "N/A", notes = "自定义Restful api 返回请求数据测试")
    @GetMapping("/response")
    public ResponseEntity <Map <String, Object>> getUser() throws IOException {
        Map <String, Object> map = new HashMap <String, Object>();
        Note note = new Note();
        note.setId(123L);
        note.setTitle("foobar");
        map.put("name", "kavanLi");
        map.put("note", note);
        return new ResponseEntity <Map <String, Object>>(map, HttpStatus.OK);
    }

    /* private methods ----------------------------------------------------- */

    /* getters/setters ----------------------------------------------------- */

}