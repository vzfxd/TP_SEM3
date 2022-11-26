/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.composite.model;


/**
 * @author jpereira
 * 
 */
public abstract class Shape {

	private int x;
	private int y;

	public CompositeShape asComposite() {
		if(this instanceof CompositeShape) return (CompositeShape) this;
		return null;
	}

	public void move(int xIncrement, int yIncrement) {
		this.x += xIncrement;
		this.y += yIncrement;
		if(this instanceof CompositeShape){
			for(Shape shape : this.asComposite().getShapes()){
				shape.move(xIncrement,yIncrement);
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public abstract ShapeType getType();

}
