import 'package:flutter/material.dart';

class TasksTile extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListTile(
      title: Text('Go to the gym.'),
      trailing: Checkbox(
        onChanged: null,
        value: false,
      ),
    );
  }
}
