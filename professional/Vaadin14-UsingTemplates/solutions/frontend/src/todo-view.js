import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-checkbox/vaadin-checkbox.js';
import '@polymer/paper-input/paper-input.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
class ToDoView extends PolymerElement {
    static get template() {
        return html `
           <div>
            <paper-input placeholder="Enter your task here" on-change="onNewToDo" value="{{newText}}"></paper-input>
           </div>
           <template is="dom-repeat" items="[[toDoList]]">
            <div>
             <vaadin-checkbox value="[[item.done]]"></vaadin-checkbox> [[item.text]]
            </div>
           </template> `;
    }

    static get is() {
        return 'todo-view'
    }
}
customElements.define(ToDoView.is, ToDoView);