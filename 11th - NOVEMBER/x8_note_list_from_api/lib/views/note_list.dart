import 'package:flutter/material.dart';
import 'package:test_polo/models/note_for_listing.dart';
import 'package:test_polo/views/note_delete.dart';
import 'package:test_polo/views/note_modify.dart';

class NoteList extends StatelessWidget {
  final notes = [
    NoteForListing(
      noteID: '1',
      noteTitle: 'Note title 1',
      createDateTime: DateTime.now(),
      latestEditedDateTime: DateTime.now(),
    ),
    NoteForListing(
      noteID: '2',
      noteTitle: 'Note title 2',
      createDateTime: DateTime.now(),
      latestEditedDateTime: DateTime.now(),
    ),
    NoteForListing(
      noteID: '3',
      noteTitle: 'Note title 3',
      createDateTime: DateTime.now(),
      latestEditedDateTime: DateTime.now(),
    )
  ];

  String formatDateTime(DateTime dateTime) =>
      "${dateTime.day}/${dateTime.month}/${dateTime.year}";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('List of Notes'),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.of(context)
              .push(MaterialPageRoute(builder: (_) => NoteModify()));
        },
        child: Icon(Icons.add),
      ),
      body: ListView.separated(
        itemBuilder: (_, index) {
          return Dismissible(
            key: ValueKey(notes[index].noteID),
            direction: DismissDirection.startToEnd,
            onDismissed: (direction) {
              //
            },
            confirmDismiss: (direction) async {
              //
              final result = await showDialog(
                context: context,
                builder: (_) => NoteDelete(),
              );
              print(result);
              return result;
            },
            background: Container(
              color: Colors.red,
              padding: EdgeInsets.only(left: 16.0),
              child: Align(
                alignment: Alignment.centerLeft,
                child: Icon(
                  Icons.delete,
                  color: Colors.white,
                ),
              ),
            ),
            child: ListTile(
              onTap: () {
                Navigator.of(context).push(MaterialPageRoute(
                    builder: (_) => NoteModify(
                          noteID: notes[index].noteID,
                        )));
              },
              title: Text(
                notes[index].noteTitle,
                style: TextStyle(color: Theme.of(context).primaryColor),
              ),
              subtitle: Text(
                  'Latest edited on ${formatDateTime(notes[index].latestEditedDateTime)}'),
            ),
          );
        },
        separatorBuilder: (_, __) => Divider(
          height: 1,
          color: Colors.green,
        ),
        itemCount: notes.length,
      ),
    );
  }
}
