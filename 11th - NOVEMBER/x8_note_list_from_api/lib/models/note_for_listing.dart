class NoteForListing {
  String noteID;
  String noteTitle;
  DateTime createDateTime;
  DateTime latestEditedDateTime;

  NoteForListing({
    this.createDateTime,
    this.latestEditedDateTime,
    this.noteID,
    this.noteTitle,
  });
}
