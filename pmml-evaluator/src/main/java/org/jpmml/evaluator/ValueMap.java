/*
 * Copyright (c) 2017 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

public class ValueMap<K, V extends Number> extends LinkedHashMap<K, Value<V>> implements Iterable<Value<V>> {

	public ValueMap(){
	}

	public ValueMap(int initialCapacity){
		super(initialCapacity);
	}

	public ValueMap(Map<K, Value<V>> map){
		super(map);
	}

	@Override
	public Iterator<Value<V>> iterator(){
		return values().iterator();
	}

	public Map<K, Double> asDoubleMap(){
		Function<Value<V>, Double> function = new Function<Value<V>, Double>(){

			@Override
			public Double apply(Value<V> value){
				return value.doubleValue();
			}
		};

		return Maps.transformValues(this, function);
	}
}