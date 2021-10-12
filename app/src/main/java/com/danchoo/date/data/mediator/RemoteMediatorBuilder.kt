package com.danchoo.date.data.mediator


/**
 *
 * Retrofit 을 사용한다.
 *
 * Request 를 호출 할 것인지 Local Cache 를 조회할 것인지 판단하여
 * 최신의 데이터를 return or callback 으로 전달 시켜준다.
 *
 * Request 를 호출하여 Response 를 받는다
 * 어떤 조건이든 무조건 Request 를 호출 할수 있어야 한다.
 * Request 의 호출이 n초 미만에서 여러번 호출 되었을 경우 Local Cache 에서 데이터를 반환 한다.
 * Local Cache 가 있는 경우 Local Cache 부터 보여준다.
 * Local Cache 가 있더라도 Response 가 처리된 이후 DB에 저장하고 보여준다.
 *
 * Request Queue 관리를 할 수 있어야 한다.
 * Request 마다 Queue 를 사용 여부를 선택 할 수 있어야 한다.
 * Queue 는 한개가 아니다.
 *
 * 여러곳에서 같은 Request 를 호출 했을 때 한번만 호출 하여 동시에 받을 수 있도록 처리한다.
 *  - Cache 와 무관 Queue 에서 같은 Request 면 response 를 처리할때 broadcast 형식?
 *
 * Request Cancel / Retry 제어가 쉬워야 한다.
 *
 * Upload / Download 도 고려해야 한다.
 *
 * WorkManager 에서 사용 가능 해야 한다.
 *
 * normal / suspend / flow 에서 모두 사용 할 수 있어야 한다.
 *
 * 일반 적으로 사용하는 방식 보다 느리면 안된다!!!!!!
 *
 * ===========================================================================
 * Paging 도 지원할 수 있으면 좋을 듯 하다. (Local / Remote)
 *
 * 한곳에서 Request 를 호출 하고 Response 를 여러곳에서 받을 수 있으면 어떨까?? (Broadcast)
 *
 *
 */
class RemoteMediatorBuilder {
}