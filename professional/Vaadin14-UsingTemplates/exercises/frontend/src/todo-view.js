import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-checkbox/vaadin-checkbox.js';
import '@polymer/paper-input/paper-input.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
class ToDoView extends PolymerElement {
    static get template() {
        return html `
   <div>  
    <!-- bind the 'value' property of paper-input to a String, like 'newText' in the Model --> 
    <!-- add a server side listener method for the 'on-change' event -->
    <paper-input placeholder="Enter your task here" value="{{text}}" on-change="handleAdd"></paper-input> 
   </div> 
   <!-- bind the 'items' property of the element to a list defined in the Model--> 
   <template is="dom-repeat" items="[[toDoList]]"> 
    <div> 
     <!-- create a vaadin-checkbox element and bind its 'value' to 'done' property of the item -->
        <vaadin-checkbox value="{{item.done}}"></vaadin-checkbox>
     <!-- show the 'text' of the item next to the checkbox --> 
        <span>[[item.text]]</span>
    </div> 
   </template> 
`;
    }

    static get is() {
        return 'todo-view'
    }
}
customElements.define(ToDoView.is, ToDoView);