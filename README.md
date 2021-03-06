# BlackjinBase

It is a my base library that collect common parts that are often used for rapid development.

## Dependency

[ ![Download](https://api.bintray.com/packages/dlwls5201/maven/blackjinbase/images/download.svg) ](https://bintray.com/dlwls5201/maven/blackjinbase/_latestVersion)

Then, add the library to your module in `build.gradle`
```gradle
dependencies {
    implementation 'com.blackjin.library:blackjinbase:x.y.z'
}
```

## Add Module

If you want to use by module, add blackjinbase module and then add the dependencies in `build.gradle`
```gradle
dependencies {
   implementation project(':blackjinbase')
}
```


## Enable DataBinding
BlackjinBase needs [DataBinding](https://developer.android.com/topic/libraries/data-binding)

add the `dataBinding` element to your `build.gradle` file in the app module

```
android {
    ...
    dataBinding {
        enabled = true
    }
}
```

if your `android studio's version` is more than 4.0, you can use below code instead of upper that
```
android {
    ...
     buildFeatures{
            dataBinding = true
     }
}
```

## Sample

You can see the helper class for recyclerview in [sample](https://github.com/dlwls5201/BlackjinBase/tree/master/blackjinbase/src/main/java/com/tistory/blackjinbase/sample)

## RecyclerViewFragment

## SimpleRecyclerViewFragment

Use DiffUtil.Callback
```kotlin
val diffCallback = BaseDiffUtilCallback(this.items, items)
val diffResult = DiffUtil.calculateDiff(diffCallback)
```

## SimpleAsyncRecyclerViewFragment

Use DiffUtil.ItemCallback for AsyncListDiffer
```kotlin
private val asyncDiffer = AsyncListDiffer(this, BaseDiffItemCallback<ITEM>())
```

## SimpleListRecyclerViewFragment

Use ListAdapter for AsyncListDiffer and databinding
```xml
<androidx.recyclerview.widget.RecyclerView
           android:id="@+id/list_sample"
           android:layout_width="match_parent"
           android:layout_height="0dp"
           android:layout_weight="1"
           bind:itemLayoutId="@{@layout/item_sample}"
           bind:itemList="@{items}"
           tools:listitem="@layout/item_sample" />
```

License
--------
```
   Copyright 2020 blackjin

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```